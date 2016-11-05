# JSF Challenge Solution

This repository contains the solution to the JSF challenge.

## Challenge

1. Specify a custom bean name for the **Track** bean e.g. **tracker** and then change the bean name in the view **track.xhtml**.

2. Explore the primefaces website www.primefaces.org.

3. Replace the autocomplete in the **track** view with a dropdown this could be a drop-down that is already populated with all tracking IDs in the system.


## Solution

1. Specify a custom bean name in the **@Named("tracker")** annotation of the Track class and then replace all references to the bean **track** with the name **tracker**.

2. Visit the www.primefaces.org website

3. Add a method that queries the database for a list of cargo objects, construct a map and make it available to the view via a get method. The view should be updated with a drop-down. Choose one from the prime faces website here http://www.primefaces.org/showcase/ui/input/oneMenu.xhtml.


## Solution Files

1. The solution to this challenge is in the file **Track-challenge-1.java** and **track-challenge-1.xhtml**.

3. The solution to this challenge is in the file **Track-challenge-3.java** and **track-challenge-3.xhtml**.

