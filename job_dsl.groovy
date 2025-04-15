// Ici les jobs

pipelineJob('job-dsl-plugin') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/Deyanvkc/MyMarvinBootstrap#')
                    }
                    branch('*/main')
                }
            }
            lightweight()
        }
    }
}

job{
    name("deploy-application")
}