# INSTRUCTION
Used https://github.com/bonigarcia/webdrivermanager for handling webdriver for different OS and different browsers. -> webdrivermanager artifacat in pom.xml
Used RestAssured library to create API calls for test data preconditions (Create computer entity, delete computer entity)

- Pull the project
- Maven has to be installed on computer
- Run tests by command: mvn clean install test -DsuiteXmlFile=testng.xml
- To verify test run results surefire reports can be used. Navigate to 'target/surefire-reports/' and open index.html
- ScreenshotListener to create a screenshot on a test failure


# TEST CASES

##### Verify positive search scenario

1. Enter destination 'Los Angeles'

- Verify that suggestions dropdown appears.
- Verify that 'Los Angeles' is present in suggestions

2. Select Check-In date in a date-picker as tomorrow
3. Select Check-Out date in a date-picker as today + 30 days.

- Verify that the proper amount of nights displayed under dates

4. Select how many adults as '2'
5. Select how many children as 'No children'
6. Select how many rooms as '1 room'
7. Click 'Search' button

- Verify that some results found
- Verfiy that price displayed for correct amount of nights

##### Verify search validations scenario

1. Select Check-In date in a date-picker as yesterday

- Verify that the data is crossed out.
- Verify that it is disabled and user is not able to pick it.

3. Select Check-Out date in a date-picker as yesterday.
- Verify that the data is crossed out.
- Verify that it is disabled and user is not able to pick it.

4. Select Check-In date in a date-picker as today + 1 week.
5. Select Check-Out date in a date-picker as today + 1 day.

- Verify that Check-Out date can't be prior Check-In date. And the data getting shift in proper order.

6. Select Check-In date in a date-picker as today
7. Select Check-Out date date in a date-picker as today +31 days

- Verify error message "Sorry, reservations for more than 30 nights are not possible."

6. Hover mouse on 'Im travelling for work' question icon.

Verify that info tooltip appears.

7. Enter destination as "!$#!%!#%!#%"
8. Click 'Search' button

- Verify error message that destination is invalid.


##### Verify positive search scenario - travel for work

1. Enter destination 'Los Angeles'

- Verify that suggestions dropdown appears.
- Verify that 'Los Angeles' is present in suggestions

2. Select Check-In date in a date-picker as tomorrow
3. Select Check-Out date in a date-picker as today + 1 week.
4. Select how many adults as '2'
5. Select how many children as 'No children'
6. Select how many rooms as '1 room'
7. Check in check 'Im travelling for work'
7. Click 'Search' button

- Verify that search results include features described for 'Im travelling for work option'.


##### Verify filters availability

1. Check that all filter sections are present
2. Check that all filter sub-sections are present.
3. Check that all filters have counter beside them.

##### Verify filters search general

1. Fill all necessary fields for search
2. Click 'Search' button
3. Check the results count
4. Check in all filters 
- Verify that the results count is the same as without filters.
5. Note the Star rating filter '1 star' counter 
6. Check out '1 star' filter
- Verify that search result count decreased on the same amount

#### The most important filters test cases

##### Verify budget filter

1. Click on one of 'Your budget' filters 
- Verify that the result counter equals to filter count
- Verify that the results contains only prices within the range of a budget

##### Verify Star Rating filter

1. Click on one of 'Star rating' filters (3-5 range as the most popular)
- Verify that the result counter equals to filter count
- Verify that the results contains only ratings equal to filter


##### Verify filters combinations

1. Click on filter from 'Your budget'
2. Click on filter from 'Star rating'

- Verify that the result count is equal to sum of counts of both filters
- Verify that the result is a combination of both

