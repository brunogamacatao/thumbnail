ant.mkdir(dir:"${basedir}/src/templates")
ant.mkdir(dir:"${basedir}/src/templates/scaffolding")
ant.copy(file: "${pluginBasedir}/src/templates/scaffolding/_form.gsp", todir: "${basedir}/src/templates/scaffolding")
ant.copy(file: "${pluginBasedir}/src/templates/scaffolding/Controller.groovy", todir: "${basedir}/src/templates/scaffolding")
ant.copy(file: "${pluginBasedir}/src/templates/scaffolding/create.gsp", todir: "${basedir}/src/templates/scaffolding")
ant.copy(file: "${pluginBasedir}/src/templates/scaffolding/edit.gsp", todir: "${basedir}/src/templates/scaffolding")
ant.copy(file: "${pluginBasedir}/src/templates/scaffolding/list.gsp", todir: "${basedir}/src/templates/scaffolding")
ant.copy(file: "${pluginBasedir}/src/templates/scaffolding/renderEditor.template", todir: "${basedir}/src/templates/scaffolding")
ant.copy(file: "${pluginBasedir}/src/templates/scaffolding/show.gsp", todir: "${basedir}/src/templates/scaffolding")