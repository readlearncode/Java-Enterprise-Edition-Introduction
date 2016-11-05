# JMS Challenge Solution

This repository contains the solution to the JMS challenge.

## Challenge

Implement an observer that listens for cargo events. When it receives a cargo event it adds it to a collection. Then write a view that displays the handled cargos in a data table.

A hint, have a look at the **RealtimeCargoTrackingService** class **onCargoInspected** method.

## Solution

For the solution you will need a method that listens for cargo events and a collection in which to store the cargo objects.

This will be a backing bean so that it is visible to a JSF view and also it should have application scope because we want it to maintain the list of cargos across all sessions.

Now we need a view to display the cargos. Here I have created a view named **showHandledCargos** and I use the **dataTable** component from prime faces. You can visit the www.primefaces.org web site to more ways to display data.

## Solution Files

The class file **HandledCargo.class** should reside in the package **net.java.cargotracker.interfaces.tracking.web**.

The JSF template file **showHandledCargos.xhtml** should reside in the **src/main/webapp/admin/** directory.


