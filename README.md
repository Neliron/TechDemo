# Démonstration technique

Pour lancer le backend sur IntelliJ :

    Créer une build Application, avec la classe "com.eaton.techDemo.TechDemoApplication".
    Lancer le build.
    Le backend devrait être accessible à l'adresse http://localhost:8080/devices/getDevices (qui devrait renvoyer un JSON contenant tous les devices ainsi que leurs métriques).

Pour le frontend :

    Avec une console, aller dans le dossier techDemo/ui.
    Lancer la commande ng serve.
    Le frontend devrait être accessible à l'adresse http://localhost:4200/

La page du frontend se recharge toutes les 2 secondes en récupérant les nouvelles métriques.

La mise à jour des métriques est gérée côté backend de manière autonome (ce n'est pas le rafraichissement du frontend qui le déclenche).
