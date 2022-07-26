# Cash Register Exercise
## Requirements

Write a Java command line (cli) program to create a cash register program.  
A project skeleton has been created in this repository.

Feel free to install any public Java packages you need by adding them to 
the `build.gradle` file.

## Acceptance Criteria

The project should render the change required when executed with total amount and
cash received passed as parameters.  The first parameter should be the total
amount due.  The second parameter should be the cash received from the customer.

When complete, another developer should be able to clone/checkout the code and
run `gradle build` in a Java/Gradle environment to install dependencies. 
After this, running `javac cashregister.java` should execute the
program.

* `javac cashregister.java` without parameters or with a --help flag should output 
the program usage documentation.
* `javac cashregister.java <total_due> <cash_received>` should return the change due
* The output should detail the change to be given in total amount and then
broken down into number of bills/coins.  The bills/coins should be returned in
increasing denomination to mirror how a cashier should count change.

## Assumptions

Your register currently contains the following denominations:

'PENNY': 0.01  
'NICKEL': 0.05  
'DIME': 0.10  
'QUARTER': 0.25  
'ONE': 1.00  
'FIVE': 5.00  
'TEN': 10.00  
'TWENTY': 20.00  
'FIFTY': 50.00  
'ONE HUNDRED': 100.00  

### Output

* When the cash received is less than the purchase price, display balance due with amount.
* If cash received is equal to the purchase price, display 0.
* If cash received is greater than the purchase price, display the numerical value of change due along with the denomination names and quantities to return (sorted by the denomination from the smallest to largest).
* Handle any input errors.

#### Example 1

Total due: $35.94  
Cash received input: $40.00  
Command: `javac cashregister.java 35.94 40`
Expected output: $4.06 (1 PENNY, 1 NICKEL, 4 ONE)  

#### Example 2 (bad input)

Total due: $37.90  
Cash received input: as40  
Command: `javac cashregister.java 37.90 as40`
Expected output: Display error to user with reason/resolution.

#### Example 3 (exact change)

Total due: $29.50  
Cash received input: $29.50  
Command: `javac cashregister.java 29.50 29.50`
Expected output: $0.00  

#### Example 4

Total due: $29.50  
Cash received input: $100  
Command: `javac cashregister.java 70.50 100`
Expected output: $29.50 (2 QUARTER, 4 ONE, 1 FIVE, 1 TWENTY)  

#### Example 5 (balance due)

Total due: $134.67
Cash received input: $100  
Command: `javac cashregister.java 134.67 100`
Expected output: $-34.67 Due

## Getting Started

* Create a repository
* Create a branch for your work
* Complete exercise (committing as you work)
* Push your work branch to Github
* Open a Pull Request (PR) in Github from your branch into master.
* Be ready to discuss how you solved the challenge and reasons for choices you made as well as how you resolved any issues that came up in the development process.

At any time you can push to github and open a PR for discussion if you have any questions.
