mainscreen.html line19: changed header to Coffee Corner
mainscreen.html line21: changed parts to Snacks
mainscreen.html line53: changed products to Coffee
mainscreen.html line19: aligned header text to center
mainscreen.html line16: added background color to body
mainscreen.html line33: changed inhouse parts to Snack
mainscreen.html line34: changed outsourced parts to Dessert

Created about.html file
about.html line8: added header "Our Story"
about.html line9: added subheader "Why we do it"
about.html line10: added p element with brief mission statement
about.html line13: added second subheader "Where we come from"
about.html line14: added second p element with brief backstory
about.html line18: added link back to main screen
mainscreen.html line20-line22: added About us link

Created AboutController java file
AboutController line6: Annotated the class with Controller
AboutController line9: Annotated method with GetMapping to /about
AboutController line10: created String method to return about.html upon request

BootstrapData.java line23: added snackRepo and changed necessary file names
BootstrapData.java line25: added dessertRepo and changed necessary file names
BootstrapData.java line26: added partRepo
BootstrapData.java line38: added if statement to check partRepo to prevent duplicates
BootstrapData.java line39-line74: added 2 snack objects and 3 dessert objects
BootstrapData.java line75: added if statement to check productRepo to prevent duplicates
BootstrapData.java line76-line104: added 5 Coffee products

AddProductController.java line176-line181: added buyCoffee method
mainscreen.html line92: added buy now button to product table
Created badBuy.html and goodBuy.html files
badBuy.html line10: added header element
badBuy.html line12: added link back to main screen
goodBuy.html line10: added header element
goodBuy.html line12: added link back to main screen

Part.java line31: added minInv variable
Part.java line33: added maxInv variable
Part.java line96-line109: added getters and setter for minInv and maxInv
Bootstrap.java line45-line82: set minInv and maxInv for each snack or dessert object
mainscreen.html line41-line42: added minInv and maxInv columns to table
mainscreen.html line51-line52: added minInv and maxInv table data
InhousePartForm.html line16: added snack name
InhousePartForm.html line19: added snack price
InhousePartForm.html line23: added snack inventory
InhousePartForm.html line27: added snack id
InhousePartForm.html line30: added snack min inv
InhousePartForm.html line34: added snack max inv
InhousePartForm.html line10: changed header to Snack Details
OutsourcedPartForm.html line10: changed header to Dessert Details
OutsourcedPartForm.html line17: added dessert name
OutsourcedPartForm.html line20: added dessert price
OutsourcedPartForm.html line24: added dessert inventory
OutsourcedPartForm.html line28: added dessert min inventory
OutsourcedPartForm.html line32: added dessert max inventory
OutsourcedPartForm.html line36: removed company name
Created InventoryValidator.java file and ValidInventory.java interface
InventoryValidator.java line33: added condition for values higher than max
Parts.java line23: added ValidInventory annotation to class
InhousePartForm.html line38: added error message response
OutsourcedPartForm.html line36: added error message response
InventoryValidator.java line39: added condition for values lower than min

productForm.html line12: changed header to Coffee Details
productForm.html line17: added Coffee name
productForm.html line20: added Coffee price
productForm.html line24: added Coffee inventory
productForm.html line11: added background color to match main screen
InhousePartForm.html line9: added background color to match main screen
OutsourcedPartForm.html line9: added background color to match main screen
productForm.html line77: added link back to main screen
productForm.html line76: added break to add space between added parts list and link to main screen
ValidEnufParts.java line20: changed error message
mainscreen.html line28: changed Search button background color
mainscreen.html line30: changed clear button background color
mainscreen.html line64: changed Search button background color
mainscreen.html line66: changed clear button background color
InhousePartForm.html line45: changed Submit button background color
OutsourcedPartForm.html line43: changed Submit button background color
productForm.html line32: changed Submit button background color

PartTest.java line130: created minInv test
PartTest.java line140: created maxInv test
Removed DeletePartValidator because it had ZERO usages
saveproductscreen.html line7: added background color to match main screen
saveproductscreen.html line8: changed p element to h1 element and centered text
badBuy.html line9: added background color to match main screen
goodBuy.html line9: added background color to match main screen
