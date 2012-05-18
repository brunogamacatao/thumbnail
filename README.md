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

1. To use this plugin into you application you first have to open the `grails-app/conf/BuildConfig.groovy` file and uncomment the `mavenLocal()` line;
2. This plugin creates a new datatype `bgc.thumbnail.Thumbnail` you may use it whenever you want a picture on your domain classes;
3. The thumbnail plugin overrides the default scaffolding templates, so it will handle correctly the uploading and display of `bgc.thumbnail.Thumbnail` fields.

Example
-------

1. Create a project:

        grails create-app thumbsample

2. Enter the created application directory:

        cd thumbsample

3. Edit the `grails-app/conf/BuildConfig.groovy` and uncomment the `mavenLocal()` line (probably it is the 27 line);

4. Install the Burning Image plugin:

        grails install-plugin burning-image

5. Install the thumbnail plugin:

        grails install-plugin thumbnail

6. Create a domain class:

        grails create-domain-class Person

7. Edit the generated domain class `grails-app/domain/thumbsample/Person.groovy`:

        package thumbsample
        
        import bgc.thumbnail.Thumbnail
        
        class Person {
            String name
            Thumbnail picture
            
            static constraints = {
                name(blank: false)
                picture(blank: false)
            }
        }

8. Create a controller for the Person domain class:

        grails create-controller Person

9. Edit the generated controller `grails-app/controller/thumbsample/PersonController.groovy`:

        package thumbsample
        
        class PersonController {
            def scaffold = true
        }

10. Run the project:

        grails run-app

11. Enjoy it ! (open the `http://localhost:8080/thumbsample/person` URL on your browser)

    Open the generated views, create a new person, updated it and see the listing.


Taglib
------

The thumbnail plugin includes a single tablib `<g:thumbnail>` with the following attributes:

* **id** (obrigatory): The id of the thumbnail attribute;
* **width** (optional): The width you want your thumbnail to be displayed;
* **height** (optional): The height you want your thumbnail to be displayed;
* **class** (optional): The css class to be applied on the generated html img tag.

### Example:

    <g:thumbnail id="${personInstance.picture.id}" width="50" height="50"/>

Screenshots
-----------

### Create Person Screen:

![Create Person Screen](https://github.com/brunogamacatao/thumbnail/raw/master/screenshots/create.png "Create Screen")

### Show Person Screen:

![Show Person Screen](https://github.com/brunogamacatao/thumbnail/raw/master/screenshots/show.png "Show Screen")

### Edit Person Screen:

![Edit Person Screen](https://github.com/brunogamacatao/thumbnail/raw/master/screenshots/edit.png "Edit Screen")

### Person List Screen:

![Person List Screen](https://github.com/brunogamacatao/thumbnail/raw/master/screenshots/list.png "List Screen")
