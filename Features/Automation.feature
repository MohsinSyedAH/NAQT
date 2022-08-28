
Feature: Automation

Scenario:Automating Numadic Careers Page

Given Open the application link "<Mainurl>"
Then Verfiy The header text "<Headertxt>"
And Select Internship from job type dropdown list
Then The Message Should Be "<Msg>"
When Select  Full time from job type dropdown list
And Select QA Engineer From job listing options
Then Verify url redirects to "<redriectUrl>"
And Verify button Apply here now &  perform a click action
Then Verify redirect back to careers page
When On listing page, hover over QA Engineer
Then Apply button will Be Visible and click Apply button
And  Verify validation for all fields under Personal details such as "<FirstName>","<LastName>","<Email>","<MobNo>","<Sport>","<Pet>","<CurrentCity>","<HomeTown>","<DOB>"
Then Close the Browser

Examples:

|Mainurl|Headertxt|Msg|redriectUrl|FirstName|LastName|Email|MobNo|Sport|Pet|CurrentCity|HomeTown|DOB|
|https://numadic.com/careers/|JOIN OUR CREW|There are no available job positions that match your filters.|https://numadic.com/careers/qa-engineer.php|Mohsin Syed|Akram Husain|mohsinsyed0308@gmail.com|9766391927|Football|Cats|Yavatmal|Yavatmal|03/08/1993|