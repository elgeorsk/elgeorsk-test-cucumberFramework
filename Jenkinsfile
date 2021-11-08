node{
 stage('SCM Checkout'){
git 'https://github.com/Autamation/sim.git'
}
	 stage('Compile-Package'){
   def mvnHome = tool name: 'maven3', type: 'maven'
      bat "${mvnHome}/bin/mvn package"
 bat 'mvn package'
	}
	}
