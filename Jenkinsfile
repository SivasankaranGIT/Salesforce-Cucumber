pipeline {
    agent any
    environment {
    	PATH = "/local/software/maven-3.5.4/bin:$PATH"
	}
    stages {
    		
    	stage('Setup') {
    		steps {
       			 dir ('Report') {
           			 deleteDir()
        		}
   			}
		}

    	stage ('Run Parallel Tests') {
    		parallel {
        		stage ('parallel_job_Quote_Samples') {

            		steps {
                   			sh 'mvn clean install -D"cucumber.filter.tags=@login or @Samples or @logout"'
                	}
        		}
        
        		stage ('parallel_job_OpportunitiesDependentTCs') {

            		steps {
            				sleep 60
                   			sh 'mvn clean install -D"cucumber.filter.tags=@login or @OpportunitiesDependent or @logout"'
                	}
        		}
        		
        		stage ('parallel_job_OpportunitiesNonDependentTCs') {

            		steps {
            				sleep 120
                   			sh 'mvn clean install -D"cucumber.filter.tags=@login or @OpportunitiesNonDependent or @logout"'
                	}
        		}
        		stage ('parallel_job_Cases') {

            		steps {
            				sleep 180
                   			sh 'mvn clean install -D"cucumber.filter.tags=@login or @Cases or @logout"'
                	}
        		}
        
        		stage ('parallel_job_Others') {

            		steps {
            				sleep 300
                   			sh 'mvn clean install -D"cucumber.filter.tags=@login or @Accounts or @Contacts or @Events or @Tasks or @Leads or @Consultant or @DigitalTrainings or @MHECourse or @Campaign or @Department or @Profiles or @E2C or @logout"'
                	}
        		} 
        		
        		stage ('parallel_job_FSL_Product_ProductCatalog_Community_DiscountWizard_A3K') {

            		steps {
            				sleep 420
                   			sh 'mvn clean install -D"cucumber.filter.tags=@login or @FSL or @Products or @ProductCatalog or @Community or @DiscountWizard or @A3K or @logout"'
                	}
        		}
        	}
        }
        
      }
        post {
        	always {

				emailext attachmentsPattern: '**/target/cucumber-reports/*Group.html', body: '''${SCRIPT, template="groovy-html.template"}''', mimeType: 'text/html', subject: 'GCRM UAT Regression Test Automation Results', to: 'ashish.gupta2@mheducation.com,shivdeep.singh@mheducation.com,Sivasankaran.Periyasamy@mheducation.com,anshul.srivastava@mheducation.com,ramkaran.singh@mheducation.com,suraj.kumar@mheducation.com'

        		}
        }
 
}