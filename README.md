# CDI Challenge Solution

This repository contains the solution to the CDI challenge.

## Challenge

Add a new page to the admin section that displays all the cargos in the system in a list on one page.

**Hint:** Visit the www.primefaces.org website for example code for the JSF frontend and for the back end think about the conversation we have about named beans and producer methods.



## Solution

Visit the prime faces website (http://www.primefaces.org/showcase/ui/data/dataList.xhtml) and search the data list section of the site which is located under the Data section and finds the code example for a basic display of data as a list.

If you scroll down you will see code for the example. We are going to use this code to create a very simple table that displays a list of cargos.

Let’s return to the backend and look at the **DefaultBookingServiceFacade**. This service is responsible for providing services related to booking cargos into the system, and perhaps there is a method there that returns a list of all cargos.

And if we scroll down we can see just such a method. The **listAllCargos()** method returns a list of all cargos currently logged into the system.

What we need to do is to make this list of cargos available to the CDI service and visible to JSF. As we have seen before we make a bean visible to JSF by annotating it **@Named** and available to CDI by annotating it **@Produces**. We want the list of cargos to be fresh for every request the user makes so we must annotate the method **@RequestScoped**.

And that’s it for the backend, we now have a list of cargo objects available for a JSF view to use.

Now over to the view.

I have already created a very simple view using the basic example code taken from the Prime Faces website.

Here I have entered the name of the bean. In this case it will be the name of the method that is given to the bean. We could have entered a custom name in the named annotation if we wanted.

And here I define the name of the variable that will reference each of the cargos in my list as the primefaces component iterates over the collection of cargos. I have called it cargo. And here is where I access the properties of the cargo object by referring to the actual names of the classes properties.

And there we have it a very simple way to display a list of cargos.

### Suggestions for improvements:

1. Use the data table component to display the cargos in a table format.
2. If a large number of cargos are loaded in the system then displaying them on the screen is not very user-friendly. So why not use the pagination component instead.



## Solution Files

The **show_cargos.xhtml** file should reside in the **webapp/admin/** directory.

The **DefaultBookingServiceFacade.java** should reside in the **net.java.cargotracker.interfaces.booking.facade.internal** package.
