Grails Thumbnail Plugin
=======================

Description
-----------

The purpose of this plugin is to ease the manipulation of images in grails applications and also to ease the generation of thumbnails.

Installation
------------

To install this game clone this project on your local filesystem:

    git clone https://github.com/brunogamacatao/thumbnail

Grails versions 2.x does not allow the installation of local zipped plugins anymore, so you do have to perform the following commands inside the thumbnail plugin directory:

    grails package-plugin
    grails maven-install

After that, the plugins will be installed on your local maven repository and thus accessible to all your Grails applications.

Usage
----

1. To use this plugin into you application you first have to open the grails-app/conf/BuildConfig.groovy file and uncomment the `mavenLocal()` line;
2. This plugin creates a new datatype `bgc.thumbnail.Thumbnail` you may use it whenever you want a picture on your domain classes;
3. The thumbnail plugin overrides the default scaffolding templates, so it will handle correctly the uploading and display of `bgc.thumbnail.Thumbnail` fields.

Example
-------

1. Create a domain class:

    grails create-domain-class Person

2. Edit the generated domain class:

    import bgc.thumbnail.Thumbnail
    
    class Person {
        String name
        Thumbnail picture
        
        static constraints = {
            name(blank: false)
            picture(blank: false)
        }
    }

3. Create a controller for the Person domain class:

    grails create-controller Person

4. Edit the generated controller:

    class PersonController {
        def scaffold = true
    }

5. Run the project:

    grails run-app

6. Enjoy it !
