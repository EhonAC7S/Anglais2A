# SpellingWizard - Anglais 2A

## Description 
### Avant-propos
Application réalisée dans le cadre de notre projet libre d'anglais. 
Nous avons choisi de créer une application Android grâce à Android Studio lors de notre projet d'anglais, dans le but de nous ouvrir au fonctionnement tant de l'IDE qu'au fonctionnement et la structure des applications Android.

### SpellingWizard
Nous avons choisi de développer une application sur le principe du projet Voltaire, qui est un outil d'apprentissage de règles de grammaire/orthographe en français. Nous avons chercher à imiter ce modèle mais avec un contenu anglais pour coller avec les consignes imposées par nos professeurs. 

### Contenu
L'application possède actuellement 2 fonctionnalités principales
#### Affichage de contenu de cours
Au démarrage de l'application, vous avez un menu principal 'MainActivity'. En cliquant sur le bouton 'Cours', on obtient un nouveau menu 'CoursActivity' listant les cours disponibles. Il n'en est affiché que 6 à la fois, mais il est possible d'en afficher de nouveau au moyen d'un bouton 'Next' qui disparait lorsque l'on ne peut plus afficher d'autres cours. Le bouton 'Previous' quand à lui permet de revenir sur les 6 précédent boutons.
Depuis le menu des cours, nous avons accès à l'ensemble des règles, avec une description et des exemples. Il est possible de rajouter des contenus de cours 'CoursesContents' dans la base de données prévue, qui est 'BdCourses'.

### Quiz pour tester ses connaissances
Depuis le menu principal, en cliquant sur le bouton 'Quiz', on lance une activité de quiz 'QuizActivity' qui est un déroulement d'une dizaine de questions prise au hasard dans la base de données 'DbHelper'. L'ajout de question se fait sur le même principe que pour l'ajout de cours. Au terme du quiz, on affiche la 'ResultActivity' qui montre le pourcentage de succès, et les règles qui n'ont pas été maîtrisées. Ces règles sont accessible depuis cette activité.



### Eventuelles améliorations 
Il serait intéressant d'ajouter un menu intermédiaire entre le menu principal et le quiz, qui listerait plusieurs quiz, avec des difficultés différents, cela demande cependant un contenu plus conséquent en terme de règles et d'exemples pour que cette feature vaille le coup d'être implémentée

## Auteurs 

 Antoine Sochala & Jordan CESARO

accès Latex du rapport : 
https://latex.telecomnancy.univ-lorraine.fr/project/58ea26d297f3eee764dce995

