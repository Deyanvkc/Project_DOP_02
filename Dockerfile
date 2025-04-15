# Image de jenkins
FROM jenkins/jenkins:lts-jdk17

# Copie du fichier plugins.txt et installation des plugins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt

# Création du dossier pour la config JCasC
RUN mkdir -p /var/jenkins_home/casc_configs && chown -R jenkins:jenkins /var/jenkins_home