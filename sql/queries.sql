	CREATE VIEW simple_company AS
	SELECT * FROM company 
	WHERE (id = 1 AND industry_id = 1) 
	ORDER BY id ASC;

	CREATE VIEW simple_city AS
	SELECT * FROM city 
	WHERE (city_name = 'Chicago' OR city_population >= 3000000) 
	ORDER BY city_population DESC;

	CREATE VIEW simple_country AS
	SELECT * FROM country
	WHERE (country_name IN ('United States', 'Mexico', 'Canada'))
	ORDER BY country_name ASC;
	
	CREATE VIEW simple_transportation AS
	SELECT * FROM transportation
	WHERE car_emission > public_emission
	ORDER BY target_id ASC;

	CREATE VIEW simple_cet AS
	SELECT * FROM carbon_emission_target
	WHERE (base_year BETWEEN 2020 AND 2030)
	ORDER BY base_year ASC;
    
    
	CREATE VIEW numeric_city AS
	SELECT SUM(city_population) FROM city
	GROUP BY country_id
	HAVING SUM(city_population) > 10000000;

	CREATE VIEW string_industry AS
	SELECT CONCAT(industry_type, ':', industry_emission) FROM industry
	WHERE industry_emission > 500;

	CREATE VIEW date_time_cet AS
	SELECT YEAR(target_year) FROM carbon_emission_target
	WHERE target_year < 2025;

    CREATE VIEW numeric_industry AS
	SELECT id, country_id, AVG(industry_emission) FROM industry
	GROUP BY country_id;
    
    	CREATE VIEW complex_company_industry AS
	SELECT * FROM company JOIN industry
	ON (company.industry_id = industry.id);

	CREATE VIEW complex_transportation_cet AS
	SELECT * FROM carbon_emission_target JOIN transportation
	ON (cet_id = target_id);
	
	CREATE VIEW complex_country AS
	SELECT * FROM country JOIN industry
	ON (cet_id = target_id);
	
	CREATE VIEW subquery_city AS
	SELECT city_name FROM city C
	WHERE city_population <= (SELECT AVG(population) FROM city WHERE city.country_id = c.country_id);

	CREATE VIEW subquery_exists_country_industry AS
	SELECT country_name, country_population FROM country
	WHERE EXISTS (SELECT * FROM Industry WHERE industry.country_id = country.id AND industry_emission >= 1000);