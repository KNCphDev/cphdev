# Prerequisites and howto


## 1. install Node.js
1. Download from http://nodejs.org/
2. Start _Node.js Command Prompt_ through the Windows Start Menu. (Alternatively it can be run from an ordinary command prompt with added path / environment settings.)
3. Run the following command: *"npm install"*
(If you get errors relating to phantomjs install, please run *"npm config set strict-ssl false"*.)
4. Move to project directory and start the web server with *"npm start"*
5. View page in browser - http://localhost:8000
6. To run e2e-tests - "*npm run protractor*"

## 2. Install MongoDB
1. Download MongoDB from http://www.mongodb.org/
2. Create data directory (e.g. *c:\cphdev\data\*)
3. Start MongoDB with *mongod --dbpath=c:\cphdev\data*

## Run backend project
 1. cd happiness-rs
 2. mvn exec:java

## Suggestions
1. https://www.openshift.com/ (hosting)
2. travis-ci.org
