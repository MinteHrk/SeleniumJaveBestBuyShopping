# SeleniumJaveBestBuyShopping
Q) Create a test automation suite using Selenium, Cucumber, Maven, and XML files to run tests,
pass step data from an Excel file, and utilize XML parameters to reuse steps for different phone
searches? The task involves performing the following actions on the BestBuy website:
1) Open the BestBuy website.
2) Search for &#39;Iphone 13&#39; in the top search bar and click the search icon.
3) Wait for the search results to load. (Don’t use thread.sleep)
4) Find an item with a
description -Apple - Pre-Owned iPhone 13 Pro 5G 128GB (Unlocked) - Graphite
model - A2483-GRY
price - $879.99
5) Click on &#39;Add to Cart.&#39;
6) Verify that a popup appears with the text 'The item you added to cart'; (This doesn't show on the page mentioned so I did a checkout and order summary validation)
7) Find another item by using steps 2,3,5,6(Reuse steps)
Search - iphone 12
Descr - Apple - iPhone 12 5G 64GB (Unlocked) - Black
Model: MGF43LL/A
Price - $629.99
8) Verify that you are on the Cart page by validating the presence of &#39;Order Summary&#39; and
the &#39;Check out&#39; button.

Note: Follow the best practices of cucumber and selenium and should use feature file and xml
parameters to pass the data.
 Check solution
