Glossary

**Entity Name: city**

Synonyms: Area

Description: A city is a place within a country. There can be multiple cities within one country, and each city can only be part of one country. A city also uses one energy_management and one waste_management. A city may or may not contain a carbon_emission_target.

Attributes:\
**city_id (PK)**\
Data Type: INTEGER\
Description: city_id is the primary key for the city entity. Each city will have a unique city_id that it can be identified with.\
Maximum: 1-1. The city_id is unique and each ID can only describe one city.\
Cardinality: NOT NULL

**city_name**\
Data Type: VARCHAR(50)\
Description: city_name is the name of the city.\
Maximum: M-1. city_name is NOT unique and multiple cities can have the same name. However, each city can only have one name.\
Cardinality: NOT NULL

**city_population**\
Data Type: INTEGER\
Description: The city_population is the amount of people that the city has living within it.\
Maximum: M-1. city_population is NOT unique and multiple cities can have the same population. However, each city can only have one value for population.\
Cardinality: NULL

**population_density**\
Data Type: FLOAT\
Description: The population_density is the number of people per square mile of land area.\
Maximum: M-1. population_density is NOT unique and multiple cities can have the same population density. However, each city can only have one value for population density.
Cardinality: NULL

**country_id (FK)**\
Data Type: INTEGER\
Description: The country_id refers to the country the city is in. This value can be used to join the city table with the country table.\
Maximum: M-1. Although country_id is 1-1, multiple cities can be in the same country (have the same country_id). Each city can only have one country_id.
Cardinality: NOT NULL

**Entity Name: country**

Synonyms: Nation, State

Description: A country is place. A country can have multiple cities exist within it. A country can have one or more industries. A country can also have many users living in the country.

Attributes:\
**country_id (PK)**\
Data Type: INTEGER\
Description: country_id is the primary key for the country entity. Each country will have a unique country_id that it can be identified with.\
Maximum: 1-1. The country_id is unique and each country_id can only describe one city.
Cardinality: NOT NULL

**country_name**\
Data Type: VARCHAR(50)\
Description: country_name is the name of the country.\
Maximum: 1-1. country_name is unique and multiple countries cannot have the same name. Each country can only have one name.\
Cardinality: NOT NULL

**country_population**\
Data Type: INTEGER\
Description: country_population is the amount of people living within the country.\
Maximum: M-1. Multiple countries can have the same population, but each country can only have one value for population.\
Cardinality: NULL

**Entity Name: industry**

Synonyms: Manufacturing, Production, Fabrication

Description: An industry is a branch of an economy. An industry can be part of one country. An industry can also own one or more companies.

Attributes:\
**industry_id (PK)**\
Data Type: INTEGER\
Description: industry_id is the primary key for the industry entity. Each industry will have a unique industry_id that it can be identified with.\
Maximum: 1-1. The industry_id is unique and each industry_id can only describe one industry.\
Cardinality: NOT NULL

**country_id (FK)**\
Data Type: INTEGER\
Description: country_id refers to the country the industry is in. This value can be used to join the industry table with the country table.\
Maximum: M-1. Although country_id is 1-1, multiple industries can be in the same country (have the same country_id). Each industry can only have one country_id.\
Cardinality: NOT NULL

**industry_type**\
Data Type: VARCHAR(50)\
Description: industry_type is a name that describes the type of industry. For example, an industry can be the tech industry.\
Maximum: M-1. Multiple industries can have the same industry_type and industries can have multiple industry_types (e.g. tech and healthcare).\
Cardinality: NULL

**industry_emission**\
Data Type: FLOAT\
Description: industry_emission is a number that describes the amount of CO2 emissions the industry produces.\
Maximum: M-1. Multiple industries can have the same industry_emission value, but each industry can only have one value for industry_emission.\
Cardinality: NULL

**Entity Name: company**

Synonyms: Business, Corporation

Description: A company is an entity that is part of an industry. A city can be part of one or more industries.

Attributes:\
**company_id (PK)**\
Data Type: INTEGER\
Description: company_id is the primary key for the company entity. Each company will have a unique company_id that it can be identified with.\
Maximum: 1-1. The ID is unique and each ID can only describe one industry.\
Cardinality: NOT NULL

**industry_id (FK)**\
Data Type: INTEGER\
Description: industry_id refers to the industry that the company is a part of. This value can be used to join the company table with the industry table.\
Maximum: M-1. Although industry_id is 1-1, multiple companies can be in the same industry (have the same industry_id). Each company can only have one industry_id.\
Cardinality: NOT NULL

**company_name**\
Data Type: VARCHAR(50)\
Description: company_name refers to the name of the company.\
Maximum: M-1. Multiple companies can have the same name, but each company can only have one name.\
Cardinality: NULL

**company_emission**\
Data Type: INTEGER\
Description: company_emission refers to the amount of CO2 emissions the company produces.\
Maximum: M-1. Multiple companies can have the same company_emissions, but each company can only have one value for company_emission.\
Cardinality: NULL

**Entity Name: carbon_emission_target**

*Referred as C.E.T below*

Synonyms: carbon_emission_goals, carbon_emission_objective

Description: carbon_emission_target is the plan that a city has to reduce CO2 emissions. A C.E.T must have 1 city it is a part of. A C.E.T can also have one or more transportation entites.

Attributes:\
**cet_id (PK)**\
Data Type: INTEGER\
Description: cet_id is the primary key for the C.E.T entity. Each C.E.T will have a unique cet_id that it can be identified with.\
Maximum: 1-1. The cet_id is unique and each cet_id can only describe one C.E.T.\
Cardinality: NOT NULL

**city_id (FK)**\
Data Type: INTEGER\
Description: city_id refers to the city the C.E.T is part of. This value can be used to join the C.E.T table with the city table.\
Maximum: 1-1. Since each C.E.T can only be part of one city, no C.E.Ts will have the same city_id. Each C.E.T can only have one city_id.\
Cardinality: NOT NULL

**base_year**\
Data Type: YEAR\
Description: base_year refers to the year that the C.E.T is being started. For example, if Chicago was starting its C.E.T in 2022, the base_year would be 2022.\
Maximum: M-1. Multiple C.E.Ts can have the same base_year, but each C.E.T can only have one base_year.\
Cardinality: NULL

**base_emission**\
Data Type: FLOAT\
Description: base_emission refers to the amount of CO2 emissions the city has when the C.E.T is being started.\
Maximum: M-1. Multiple C.E.Ts can have the same base_emission, but each C.E.T can only have one base_emission.\
Cardinality: NULL

**target_year**\
Data Type: YEAR\
Description: target_year refers to the year that the C.E.T is planning to be finished by. For example, if Chicago wanted to accomplish its C.E.T by 2030, the target_year would be 2030.\
Maximum: M-1. Multiple C.E.Ts can have the same target_year, but each C.E.T can only have one target_year.\
Cardinality: NULL

**target_emission**\
Data Type: FLOAT\
Description: target_emission refers to the amount of CO2 emissions the city is planning to reach by the target year.\
Maximum: M-1. Multiple C.E.Ts can have the same target_emission, but each C.E.T can only have one target_emission.\
Cardinality: NULL

**Entity Name: transporation**

Synonyms: Transit, Traffic

Description: transportation is the way people in cities get around. Each transportation entity must have a C.E.T.

Attributes:\
**transportation_id (PK)**\
Data Type: INTEGER\
Description: transportation_id is the primary key for the transporation entity. Each transportation will have a unique transportation_id that it can be identified with.\
Maximum: 1-1. The ID is unique and each ID can only describe one transportation.\
Cardinality: NOT NULL

**target_id (FK)**\
Data Type: INTEGER\
Description: target_id refers to the C.E.T that the transportation is part of. This value can be used to join the transporation table with the C.E.T table.\
Maximum: 1-1. Since each transportation can only be part of one C.E.T, no transportation will have the same target_id. Each transportation can only have one target_id.\
Cardinality: NOT NULL

**car_population**\
Data Type: INTEGER\
Description: car_population refers to the amount of people that use cars as their main form of transportation.\
Maximum: M-1. Multiple transportations can have the same car_population, but each transportation can only have one value for car_population.\
Cardinality: NULL

**car_emission**\
Data Type: FLOAT\
Description: car_emission refers to the amount of CO2 emissions the car population is producing.\
Maximum: M-1. Multiple transportations can have the same car_emission value, but each transportation can only have one value for car_emission.\
Cardinality: NULL

**public_usage**\
Data Type: INTEGER\
Description: public_usage refers to the amount of people that use public transportation as their main form of transportation.\
Maximum: M-1. Multiple transportations can have the same public_usage, but each transportation can only have one value for public_usage.\
Cardinality: NULL

**public_emission**\
Data Type: FLOAT\
Description: public_emission refers to the amount of CO2 emissions public transportation produces.\
Maximum: M-1. Multiple transportations can have the same public_emission, but each transportation can only have one value for public_emission.\
Cardinality: NULL

**Entity Name: energy_management**

Synonyms: energy_production, energy_consumption

Description: energy_management refers to how a city makes power, uses power, and the emissions that using the power creates. Each energy_management must be part of one city.

Attributes:\
**em_id (PK)**\
Data Type: INTEGER\
Description: em_id is the primary key for energy_management. Each energy_management will have a unique em_id that it can be identified with.\
Maximum: 1-1. The em_id is unique and each em_id can only describe one energy_management.\
Cardinality: NOT NULL

**city_id (FK)**\
Data Type: INTEGER\
Description: city_id refers to the city that the energy_management is a part of.\
Maximum: 1-1. Since each energy_management can only be part of one city, no energy_management will have the same city_id. Each energy_management can only have one city_id.\
Cardinality: NOT NULL

**energy_production**\
Data Type: FLOAT\
Description: energy_production refers to the amount of energy a city produces.\
Maximum: M-1. Multiple energy_managements can have the same energy_production, but each energy_production can only have one value for energy_production.\
Cardinality: NULL

**energy_consumption**\
Data Type: FLOAT\
Description: energy_consumption refers to the amount of energy a city uses.\
Maximum: M-1. Multiple energy_managements can have the same energy_consumption, but each energy_management can only have one value for energy_consumption.\
Cardinality: NULL

**energy_emission**\
Data Type: FLOAT\
Description: energy_emission refers to the amount of CO2 emissions the energy_consumption and energy_production produces.\
Maximum: M-1. Multiple energy_managements can have the same energy_emission, but each energy_management can only have one value for energy_emission.\
Cardinality: NULL

**Entity Name: waste_management**

Synonyms: waste_production, waste_reduction

Description: waste_management refers to how a city manages waste and pollution. Each waste_management must be part of one city. 

Attributes:\
**wm_id (PK)**\
Data Type: INTEGER\
Description: wm_id is the primary key for waste_management. Each waste_management will have a unique wm_id that it can be identified with.\
Maximum: 1-1. The wm_id is unique and each wm_id can only describe one waste_management.\
Cardinality: NOT NULL

**city_id (FK)**\
Data Type: INTEGER\
Description: city_id refers to the city that the waste_management is a part of.\
Maximum: 1-1. Since each waste_management can only be part of one city, no waste_management will have the same city_id. Each waste_management can only have one city_id.\
Cardinality: NOT NULL

**pollution_rate**\
Data Type: FLOAT\
Description: pollution_rate refers to the amount of pollution a city has.\
Maximum: M-1. Multiple waste_managements can have the same pollution_rate, but each waste_management can only have one value for pollution_rate.\
Cardinality: NULL

**recycle_rate**\
Data Type: FLOAT\
Description: recycle_rate refers to the amount of recycling that a city does.\
Maximum: M-1. Multiple waste_managements can have the same pollution_rate, but each waste_management can only have one value for recycle_rate.\
Cardinality: NULL

**Entity Name: user**

Synonyms: client, subscriber

Description: user refers to the users that use the database. Each user must live in a country.

Attributes:\
**email (PK)**\
Data Type: VARCHAR(50)\
Description: email is the primary key for user. Each user will have a unique email that they can be identified with.\
Maximum: 1-1. The email is unique and each email can only describe one user.\
Cardinality: NOT NULL

**country_id (FK)**\
Data Type: INTEGER\
Description: country_id refers to the country that the user lives in.\
Maximum: M-1. Although country_id is 1-1, multiple users can be in the same country (have the same country_id). Each user can only have one country_id.\
Cardinality: NOT NULL

**username**\
Data Type: VARCHAR(50)\
Description: username is the user's username.\
Maximum: 1-1. The username is unique and each username can only describe one user.\
Cardinality: NOT NULL

**password**\
Data Type: VARCHAR(50)\
Description: password is the user's password that they use to access their account.\
Maximum: M-1. Multiple users can have the same password, but each user can only have one password.\
Cardinality: NOT NULL

**name**\
Data Type: VARCHAR(50)\
Description: name is the user's name.\
Maximum: M-1. Multiple users can have the same name, but each user can only have one name.\
Cardinality: NOT NULL


**Relationships**
- transportation is dependent on carbon_emission_target. Each transportation is tracked by one carbon_emission_target.
- carbon_emission_target is dependent on city. Each carbon_emission_target must be contained by a city.
- company is dependent on industry. Each company must belong to one or more industries.
- industry is dependent on country. Each industry must be incorporated by one country.
- energy_management is dependent on city. Each energy_management must be used by one city.
- waste_management is dependent on city. Each waste_management must be managed by one city.
- city is dependent on country. Each city must exist in one country.
- user is dependent on country. Each user must live in one country.

**Cascades**
 - user
    - A user instance will be deleted if the country_id corresponding to it is deleted. (CASCADE DELETE)
 - country
    - No foreign keys. No CASCADE
- city
    - A city instance will be deleted if the country_id corresponding to it is deleted. (CASCADE DELETE)
- waste_management
    - A waste_management instance will be deleted if the city_id corresponding to it is deleted. (CASCADE DELETE)
- energy_management
    - An energy_management instance will be deleted if the city_id corresponding to it is deleted. (CASCADE DELETE)
- carbon_emission_target
    - A carbon_emission_target instance will be deleted if the city_id corresponding to it is deleted. (CASCADE DELETE)
- transportation
    - A transportation instance will be deleted if the target_id corresponding to it is deleted. It will also be deleted if the city_id of its C.E.T is deleted. (CASCADE DELETE)
- industry
    - An industry instance will be deleted if the country_id corresponding to it is deleted. (CASCADE DELETE)
- company
    - A company instance will be deleted if the industry_id corresponding to it is deleted. (CASCADE DELETE)

**Restricts**
- user
    - NOT NULL
        - email
        - country_id
        - username
        - password
        - name
- country
    - NOT NULL
        - country_id
        - country_name
    - NULL
        - country_population
- city
    - NOT NULL
        - city_id
        - country_id
    - NULL
        - city_name
        - city_population
        - population_density
- waste_management
    - NOT NULL
        - wm_id
        - city_id
    - NULL
        - pollution_rate
        - recycle_rate
- energy_management
    - NOT NULL
        - em_id
        - city_id
    - NULL
        - energy_production
        - energy_consumption
        - energy_emission
- carbon_emission_target
    - NOT NULL
        - cet_id
        - city_id
    - NULL
        - base_year
        - base_emission
        - target_year
        - target_emission
- transportation
    - NOT NULL
        - transportation_id
        - target_id
    - NULL
        - car_population
        - car_emission
        - public_usage
        - public_emission
- industry
    - NOT NULL
        - industry_id
        - country_id
    - NULL
        - industry_type
        - industry_emission
- company
    - NOT NULL
        - company_id
        - industry_id
    - NULL
        - company_name
        - company_emission