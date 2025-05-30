# LearnToCode_Capstones
 A place for all capstones

## Capstone 1: Accounting Ledger ##

This first application functions as a ledger. It allows a user to keep track of transactions. These transactions are saved to a file named "transactions.csv." The program starts by checking for an existing file under that name. If not, it initializes a new one with that name. If so, it reads in the transactions from that file and allows the user to add to it. This determination will allow for a new department to use the same program for keeping track of financial accounts. After making this determination, the screen appears to the user.

### Functions

The first screen, called the "home screen," prompts the user with 4 options: add deposit, make payment, ledger menu, and exit. Both adding a deposit and making a payment require user input to store these transactions in a list that contain 5 details:

-date (acquired automatically)

-time (acquired automatically)

-description (user input)

-vendor (user input)

-amount (user input)

Making a payment also prompts the user for payment information that is stored in the transactions.csv file.

The ledger menu exists for a user to refer back to the list of transactions. There are 5 options here: all, show deposits, show paymemts, reports menu, home.
The latest transactions are displayed in each case except for the reports menu, which leads to a new screen, and home, which returns the user to the home screen.

The reports screen can be used to generate reports of transactions by certain time periods including: month-to-date, previous month, year-to-date, previous year, or by vendor. There is also a back button that allows for the user to return to the ledger menu.

All screens continue until the user specifies to exit program.

### Screenshots

<img src=Capstone1Screenshot.png height="300">
<img src=Capstone1ScreenshotPayment.png height="300">
<img src=Capstone1ScreenshotSearch.png height="300">
