node{
 stage('SCM Checkout'){
	git 'https://github.com/elgeorsk/elgeorsk-test-cucumberFramework.git'
	}
	stage('Build') { 
		steps {
			sh 'mvn -B -DskipTests clean package' 
		}
	}
}
