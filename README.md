# Title

Wildlife-Tracker Java App


## Author

By Abigail Murugi


## Description

 This is a java application where data for animals is taken for observation if they are sick or not plus their detaails.

 Here's the link to the Github Repo :https://github.com/abbiemurugi/Caeser-Cipher


## Installation

If you want to use this as your template, here's how to go about it:

Install Git on you machine

Maneouver to 'clone or download' button and get the link

--Linux Users-- open your terminal and run the 'git clone ...' command in a directory of your choice

--for Windows Users-- Navigate to the location you'd want the repository located, right click and select "git bash here"

Clone the repository

Upon completion, navigate to the cloned repository Feel free to edit the files to your prefered taste

Now build the Database to enable storing of created instances

Install Postgres SQL

run the following commands in your terminal

CREATE DATABASE wildlife;

CREATE TABLE animals (id serial PRIMARY KEY, name varchar,ranger varchar, age varchar, location varchar, health varchar, status varchar, spotted timestamp);

CREATE TABLE sighting (id serial PRIMARY KEY, location varchar);

CREATE DATABASE wildlife_test WITH TEMPLATE wildlife;


### Prerequisites

 * Java JDK 8
 * Gradle


### Technologies used

   * JAVA
   * Gradle
   * Junit
   *Terminal

