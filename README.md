How to build and run my solution
================================
1. Clone github project using the url.
2. Import the project to eclipse IDE as maven project.
3. Program uses java 1.8 and higher to compile and run.
3. Run WebCrawler.java which is having a main method, by providing program parameter at run configuration.
4. Program parameter must be a full web url like "http://wiprodigital.com", "http://yahoo.com".
   error checkings are not done because of time factor.
4. The program writes to console its output, if a big site is given as input then the out may not be able to fit 
   with default buffer size of the console. In that case please go to Windows/Preferences/Run/Debug/Console
   and change buffer size to required size to see the output of the program.
   
   
   
Without extending the scope of the problem What could have been done If I have some more time.
==============================================================================================
1. I could have introduced Spring and could have injected HtmlParser to WebCrawler.java
2. Could have abstracted the print to console part to separate subsystem with interfaces, so that
   any other implementation of consuming web crawling results easily plugged.
3. At the moment program is executing sequentially, the whole parsing mechanism can be done in a multi threaded way
   to achieve performance gain.
4. Exception handling and error handling could have been improved.
4. At the moment the output of the program is a flat structure, although the data structure is hierarchical and 
   data is stored in Tree structure but the printing is flat hence with time I could have printed the output in a 
   visually hierarchical way.   

   
   
     
