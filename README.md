Images Microservice
====================

This project contains three modules:

- A Core project for handling all the image processing.
- A Dropwizard project with a REST interface to access the image tool.
- A Spring Root project with a REST interface to access the image tool (for frameworks comparison sake).


### DISCLAIMER

It's not a good idea to return image data in a REST service like I'm planning to do here. It ties up the application server's memory and IO bandwidth.
Much better to delegate that task to a proper web server that is optimized for this kind of transfer.
