// Création du dossier Tools
folder('Tools') {
    description('Folder for miscellaneous tools.')
}

// Job -> clone-repository
job('Tools/clone-repository') {
    description('Clone a git repo with a url given as parameter')
    parameters {
        stringParam('GIT_REPOSITORY_URL', '', 'Git URL of the repository to clone')
    }
    triggers {
        // Aucun trigger, job exécuté manuellement
    }
    steps {
        // Nettoyage du workspace avant chaque exécution
        shell('echo "Cleaning workspace" && rm -rf *')

        // Clone le dépôt Git
        shell('git clone ${GIT_REPOSITORY_URL}')
    }
    //disabled(false)  // Peut être pas nécessaire tant que pas de triggers spécifiés
}

// Job -> SEED - Crée d'autres jobs dynamiquement
job('Tools/SEED') {
    description("Job that generates jobs from the given input")
    parameters {
        stringParam('GITHUB_NAME', '', 'GitHub repository owner/repo_name')
        stringParam('DISPLAY_NAME', '', 'Display name for the job')
    }
    steps {
        dsl {
            // Script DSL pour créer un job
            """
            job("\${DISPLAY_NAME}") {
                description('Job généré dynamiquement par le SEED')
                scm {
                    git("\${GITHUB_NAME}")
                }
                triggers {
                    scm('H/1 * * * *')  // Vérification des changements toutes les minutes
                }
                steps {
                    shell('make fclean')
                    shell('make')
                    shell('make tests_run')
                    shell('make clean')
                }
            }
            """
        }
    }
    //disabled(false)  // Peut être pas nécessaire tant que pas de triggers spécifiés
}