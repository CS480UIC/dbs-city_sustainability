Glossary

**Entity Name: city**

Synonyms: Area

Description: A city is a place within a country. There can be multiple cities within one country, and each city can only be part of one country. A city also uses one energy_management and one waste_management. A city may or may not contain a carbon_emission_target.

Attributes:\
**ID (PK)**\
Data Type: INTEGER\
Description: ID is the primary key for the city entity. Each city will have a unique ID that it can be identified with.\
Maximum: 1-1. The ID is unique and each ID can only describe one city.

**city_name**\
Data Type: VARCHAR(50)\
Description: city_name is the name of the city.\
Maximum: M-1. city_name is NOT unique and multiple cities can have the same name. However, each city can only have one name.

**city_population**\
Data Type: INTEGER\
Description: The city_population is the amount of people that the city has living within it.\
Maximum: M-1. city_population is NOT unique and multiple cities can have the same population. However, each city can only have one value for population.

**population_density**\
Data Type: INTEGER\
Description: The population_density is the number of people per square mile of land area.\
Maximum: M-1. population_density is NOT unique and multiple cities can have the same population density. However, each city can only have one value for population density.

**country_id (FK)**\
Data Type: INTEGER\
Description: The country_id refers to the country the city is in. This value can be used to join the city table with the country table.\
Maximum: M-1. Although country_id is 1-1, multiple cities can be in the same country (have the same country_id). Each city can only have one country_id.

**Entity Name: country**

Synonyms: Nation, State

Description: A country is place. A country can have multiple cities exist within it. A country can have one or more industries. A country can also have many users living in the country.

Attributes:\
**ID (PK)**\
Data Type: INTEGER\
Description: ID is the primary key for the country entity. Each country will have a unique ID that it can be identified with.\
Maximum: 1-1. The ID is unique and each ID can only describe one city.

**country_name**\
Data Type: VARCHAR(50)\
Description: country_name is the name of the country.\
Maximum: M-1. country_name is NOT unique and multiple countries can have the same name. However, each country can only have one name.

**country_population**\
Data Type: INTEGER\
Description: country_population is the amount of people living within the country.\
Maximum: M-1. Multiple countries can have the same population, but each country can only have one value for population.

**Entity Name: industry**

Synonyms: Manufacturing, Production, Fabrication

Description: An industry is a branch of an economy. An industry can be part of one country. An industry can also own one or more companies.

Attributes:\
**ID (PK)**\
Data Type: INTEGER\
Description: ID is the primary key for the industry entity. Each industry will have a unique ID that it can be identified with.\
Maximum: 1-1. The ID is unique and each ID can only describe one industry.

**country_id (FK)**\
Data Type: INTEGER\
Description: country_id refers to the country the industry is in. This value can be used to join the industry table with the country table.\
Maximum: M-1. Although country_id is 1-1, multiple industries can be in the same country (have the same country_id). Each industry can only have one country_id.

**industry_type**\
Data Type: VARCHAR(50)\
Description: industry_type is a name that describes the type of industry. For example, an industry can be the tech industry.\
Maximum: M-M. Multiple industries can have the same industry_type and industries can have multiple industry_types (e.g. tech and healthcare).

**industry_emission**\
Data Type: INTEGER\
Description: industry_emission is a number that describes the amount of CO2 emissions the industry produces.\
Maximum: M-1. Multiple industries can have the same industry_emission value, but each industry can only have one value for industry_emission.

**Entity Name: company**

Synonyms: Business, Corporation

Description: A company is an entity that is part of an industry. A city can be part of one or more industries.

Attributes:\
**ID (PK)**\
Data Type: INTEGER\
Description: ID is the primary key for the company entity. Each company will have a unique ID that it can be identified with.\
Maximum: 1-1. The ID is unique and each ID can only describe one industry.

**industry_id (FK)**\
Data Type: INTEGER\
Description: industry_id refers to the industry that the company is a part of. This value can be used to join the company table with the industry table.\
Maximum: M-1. Although industry_id is 1-1, multiple companies can be in the same industry (have the same industry_id). Each company can only have one industry_id.

**company_name**\
Data Type: VARCHAR(50)\
Description: company_name refers to the name of the company.\
Maximum: M-1. Multiple companies can have the same name, but each company can only have one name.

**company_emission**\
Data Type: INTEGER\
Description: company_emission refers to the amount of CO2 emissions the company produces.\
Maximum: M-1. Multiple companies can have the same company_emissions, but each company can only have one value for company_emission.

**Entity Name: carbon_emission_target**

*Referred as C.E.T below*

Synonyms: carbon_emission_goals, carbon_emission_objective

Description: carbon_emission_target is the plan that a city has to reduce CO2 emissions. A C.E.T must have 1 city it is a part of. A C.E.T can also have one or more transportation entites.

Attributes:\
**ID (PK)**\
Data Type: INTEGER\
Description: ID is the primary key for the C.E.T entity. Each C.E.T will have a unique ID that it can be identified with.\
Maximum: 1-1. The ID is unique and each ID can only describe one C.E.T.

**city_id (FK)**\
Data Type: INTEGER\
Description: city_id refers to the city the C.E.T is part of. This value can be used to join the C.E.T table with the city table.\
Maximum: 1-1. Since each C.E.T can only be part of one city, no C.E.Ts will have the same city_id. Each C.E.T can only have one city_id.

**base_year**\
Data Type: DATE\
Description: base_year refers to the year that the C.E.T is being started. For example, if Chicago was starting its C.E.T in 2022, the base_year would be 2022.\
Maximum: M-1. Multiple C.E.Ts can have the same base_year, but each C.E.T can only have one base_year.

**base_emission**\
Data Type: INTEGER\
Description: base_emission refers to the amount of CO2 emissions the city has when the C.E.T is being started.\
Maximum: M-1. Multiple C.E.Ts can have the same base_emission, but each C.E.T can only have one base_emission.

**target_year**\
Data Type: DATE\
Description: target_year refers to the year that the C.E.T is planning to be finished by. For example, if Chicago wanted to accomplish its C.E.T by 2030, the target_year would be 2030.\
Maximum: M-1. Multiple C.E.Ts can have the same target_year, but each C.E.T can only have one target_year.

**target_emission**\
Data Type: INTEGER\
Description: target_emission refers to the amount of CO2 emissions the city is planning to reach by the target year.\
Maximum: M-1. Multiple C.E.Ts can have the same target_emission, but each C.E.T can only have one target_emission.

**Entity Name: transporation**

Synonyms: Transit, Traffic

Description: transportation is the way people in cities get around. Each transportation entity must have a C.E.T.

Attributes:\
**ID (PK)**\
Data Type: INTEGER\
Description: ID is the primary key for the transporation entity. Each transportation will have a unique ID that it can be identified with.\
Maximum: 1-1. The ID is unique and each ID can only describe one transportation.

**target_id (FK)**\
Data Type: INTEGER\
Description: target_id refers to the C.E.T that the transportation is part of. This value can be used to join the transporation table with the C.E.T table.\
Maximum: 1-1. Since each transportation can only be part of one C.E.T, no transportation will have the same target_id. Each transportation can only have one target_id.

**car_population**\
Data Type: INTEGER\
Description: car_population refers to the amount of people that use cars as their main form of transportation.\
Maximum: M-1. Multiple transportations can have the same car_population, but each transportation can only have one value for car_population.

**car_emission**\
Data Type: INTEGER\
Description: car_emission refers to the amount of CO2 emissions the car population is producing.\
Maximum: M-1. Multiple transportations can have the same car_emission value, but each transportation can only have one value for car_emission.

**public_usage**\
Data Type: INTEGER\
Description: public_usage refers to the amount of people that use public transportation as their main form of transportation.\
Maximum: M-1. Multiple transportations can have the same public_usage, but each transportation can only have one value for public_usage.

**public_emission**\
Data Type: INTEGER\
Description: public_emission refers to the amount of CO2 emissions public transportation produces.\
Maximum: M-1. Multiple transportations can have the same public_emission, but each transportation can only have one value for public_emission.

**Entity Name: energy_management**

Synonyms: energy_production, energy_consumption

Description: energy_management refers to how a city makes power, uses power, and the emissions that using the power creates. Each energy_management must be part of one city.

Attributes:\
**ID (PK)**\
Data Type: INTEGER\
Description: ID is the primary key for energy_management. Each energy_management will have a unique ID that it can be identified with.\
Maximum: 1-1. The ID is unique and each ID can only describe one energy_management.

**city_id (FK)**\
Data Type: INTEGER\
Description: city_id refers to the city that the energy_management is a part of.\
Maximum: 1-1. Since each energy_management can only be part of one city, no energy_management will have the same city_id. Each energy_management can only have one city_id.

**energy_production**\
Data Type: INTEGER\
Description: energy_production refers to the amount of energy a city produces.\
Maximum: M-1. Multiple energy_managements can have the same energy_production, but each energy_production can only have one value for energy_production.

**energy_consumption**\
Data Type: INTEGER\
Description: energy_consumption refers to the amount of energy a city uses.\
Maximum: M-1. Multiple energy_managements can have the same energy_consumption, but each energy_management can only have one value for energy_consumption.

**energy_emission**\
Data Type: INTEGER\
Description: energy_emission refers to the amount of CO2 emissions the energy_consumption and energy_production produces.\
Maximum: M-1. Multiple energy_managements can have the same energy_emission, but each energy_management can only have one value for energy_emission.

**Entity Name: waste_management**

Synonyms: waste_production, waste_reduction

Description: waste_management refers to how a city manages waste and pollution. Each waste_management must be part of one city. 

Attributes:\
**ID (PK)**\
Data Type: INTEGER\
Description: ID is the primary key for waste_management. Each waste_management will have a unique ID that it can be identified with.\
Maximum: 1-1. The ID is unique and each ID can only describe one waste_management.

**city_id (FK)**\
Data Type: INTEGER\
Description: city_id refers to the city that the waste_management is a part of.\
Maximum: 1-1. Since each waste_management can only be part of one city, no waste_management will have the same city_id. Each waste_management can only have one city_id.

**pollution_rate**\
Data Type: INTEGER\
Description: pollution_rate refers to the amount of pollution a city has.\
Maximum: M-1. Multiple waste_managements can have the same pollution_rate, but each waste_management can only have one value for pollution_rate.

**recycle_rate**\
Data Type: INTEGER\
Description: recycle_rate refers to the amount of recycling that a city does.\
Maximum: M-1. Multiple waste_managements can have the same pollution_rate, but each waste_management can only have one value for recycle_rate.

**Entity Name: user**

Synonyms: client, subscriber

Description: user refers to the users that use the database. Each user must live in a country.

Attributes:\
**email (PK)**\
Data Type: VARCHAR(50)\
Description: email is the primary key for user. Each user will have a unique email that they can be identified with.\
Maximum: 1-1. The email is unique and each email can only describe one user.

**country_id (FK)**\
Data Type: INTEGER\
Description: country_id refers to the country that the user lives in.\
Maximum: M-1. Although country_id is 1-1, multiple users can be in the same country (have the same country_id). Each user can only have one country_id.

**username**\
Data Type: VARCHAR(50)\
Description: username is the user's username.\
Maximum: 1-1. The username is unique and each username can only describe one user.

**password**\
Data Type: VARCHAR(50)\
Description: password is the user's password that they use to access their account.\
Maximum: M-1. Multiple users can have the same password, but each user can only have one password.

**name**\
Data Type: VARCHAR(50)\
Description: name is the user's name.\
Maximum: M-1. Multiple users can have the same name, but each user can only have one name.


**Relationships**
- transportation is dependent on carbon_emission_target. Each transportation is tracked by one carbon_emission_target.
- carbon_emission_target is dependent on city. Each carbon_emission_target must be contained by a city.
- company is dependent on industry. Each company must belong to one or more industries.
- industry is dependent on country. Each industry must be incorporated by one country.
- energy_management is dependent on city. Each energy_management must be used by one city.
- waste_management is dependent on city. Each waste_management must be managed by one city.
- city is dependent on country. Each city must exist in one country.
- user is dependent on country. Each user must live in one country.