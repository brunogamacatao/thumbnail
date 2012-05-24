class ThumbnailGrailsPlugin {
    // the plugin version
    def version = "1.3"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.0 > *"
    // the other plugins this plugin depends on
    def dependsOn = ["burningImage": "* > 0.5"]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def title = "Thumbnail Plugin" // Headline display name of the plugin
    def author = "Bruno Gama Catao"
    def authorEmail = ""
    def description = '''\
Simple plugin for handling image thumbnails.
'''

    // URL to the plugin's documentation
    def documentation = "https://github.com/brunogamacatao/thumbnail/blob/master/README.md"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
   def license = "APACHE"

    // Location of the plugin's issue tracker.
   def issueManagement = [ system: "github", url: "https://github.com/brunogamacatao/thumbnail/issues" ]

    // Online location of the plugin's browseable source code.
   def scm = [ url: "https://github.com/brunogamacatao/thumbnail" ]

    def doWithSpring = {
      thumbnailEditorRegistrar(ThumbnailEditorRegistrar) {
        thumbnailService = ref("thumbnailService")
      }
    }
}
