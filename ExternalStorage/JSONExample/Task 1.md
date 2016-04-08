#Notes for Task 1

JSON File contains a list of data that will not be required for this sample application, but the data itself gives a lot of information about the file.

For example, this isn't all of the events, it is only 10 of them(page_size) and there is a total of 21 pages(but this could have been calculated from total_items/page_size)

This suggests there may be a way for the size of this subset of data to be selected when making the original request for data.

After these key/value pairs there is an array called events which further contains an event object
Within this there is an array of 10 objects, which contain more data than worth listing here.

Previous data at the top of the file suggests that the size of this array is either page_size or <page-size if on the last page, meaning that it can not be relied on to always be page_size!

Of note(for the following application) would probably be the key values called:
* title
* description
* image
* url
