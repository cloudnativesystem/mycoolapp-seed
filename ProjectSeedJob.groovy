// Jenkins Job DSL to create Jobs

//Base Path For All Jobs Related to this project
def basePath = 'MycoolappProject';

//Folder already exists. Seed job inside of it
folder (basePath) {
  displayName('MycoolappProject');
  description('Folder for MycoolappProject');
}


//Git repository for mycoolapp-globalsettings
def repoUrl = "https://github.com/cloudnativesystem/mycoolapp-globalsettings.git"; //Repository UrL

pipelineJob(basePath + "/mycoolapp-globalsettings") { //JobName
  description("Global Micro Service Application Settings for K8S");
  definition {
    cpsScm {
      scriptPath("Jenkinsfile"); //Path to Build Script
      scm {
        git {
          remote {
            url(repoUrl); //Git Repository
            branch("master");
            credentials("REPLACE_ME");
          }
        }
      }
      triggers {
        gitlabPush();
      }
    }
  }
}


//Git repository for mycoolapp-userportal
repoUrl = "https://github.com/cloudnativesystem/mycoolapp-userportal.git"; //Repository UrL

pipelineJob(basePath + "/mycoolapp-userportal") { //JobName
  description("Application frontend for the user portal");
  definition {
    cpsScm {
      scriptPath("Jenkinsfile"); //Path to Build Script
      scm {
        git {
          remote {
            url(repoUrl); //Git Repository
            branch("master");
            credentials("REPLACE_ME");
          }
        }
      }
      triggers {
        gitlabPush();
      }
    }
  }
}


//Git repository for mycoolapp-accounts
repoUrl = "https://github.com/cloudnativesystem/mycoolapp-accounts.git"; //Repository UrL

pipelineJob(basePath + "/mycoolapp-accounts") { //JobName
  description("Accounts Microservice");
  definition {
    cpsScm {
      scriptPath("Jenkinsfile"); //Path to Build Script
      scm {
        git {
          remote {
            url(repoUrl); //Git Repository
            branch("master");
            credentials("REPLACE_ME");
          }
        }
      }
      triggers {
        gitlabPush();
      }
    }
  }
}


