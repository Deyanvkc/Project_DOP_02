# Image de jenkins
FROM jenkins/jenkins:lts

# Copie du fichier plugins.txt et installation des plugins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt

COPY my_marvin.yml /var/jenkins_home/casc_configs/my_marvin.yml

ENV CASC_JENKINS_CONFIG=/var/jenkins_home/casc_configs