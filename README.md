Images Microservice
====================

A simple microservice for retrieving images from Amazon S3. The image should be requested with a named size, which is predefined. Currently only one size is available: thumbnail.

If the resized image doesn't exist on the bucket, a new one is going to be generated and stored. The original image should be already in place for the resizing to happen, of course.

This project contains two modules:

- A Core project for handling all the image processing.
- A Dropwizard project with a REST interface to request the image.

Requesting
----------

Once the microservice is running, it can be accessed through the address localhost:8080/application. The available endpoints will be listed on the console.

### DISCLAIMER

It's not a good idea to return image data in a REST service like I do here. It ties up the application server's memory and IO bandwidth.
It's much better to delegate that task to a proper web server that is optimized for this kind of transfer.

*** This is a educational project and should not be used in production environments whatsoever. ***

