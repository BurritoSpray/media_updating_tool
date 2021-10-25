# media_updatitng_tool
Tool pour mettre a jour mes series

Fonctionnement: Scan un repertoire contenant des media dont les nom son compatibles avec la convention de Plex https://support.plex.tv/articles/naming-and-organizing-your-tv-show-files/

Permet de savoir si il manque des épisodes dans votre collection de média et dans le cas ou il vous en manque une liste avec toute les épisode et saisons manquants sera créé

Le but est de facilité la maintenance d'une bibliotheque Plex a grand volume

Les fonctionnalité son propices au changements vu l'état prématuré du code

Fonctions prévues : 
- Renomage de titre pour correspondre a la convention de Plex
- Ajout du nom d'épisode dans le nom de fichier pour les séries
- Auto-identification de Titre et création d'un fichier contenant le ID de TMDB pour faciliter la reconnaissance des médias
- Création d'un fichier contenant les infos sur le média probablement le même fichier que pour le ID TMDB

Fonctions en cours :
- API compatible avec TMDB (En cours)
- Scan recursif de répertoires pour la découverte de média (partielement completer)
- Détection des nom et info de saisons en utilisant les nom de fichiers (Fonctionne mais plus de test son nécessaire)

Fonctions complétées :
- Aucune pour le moments :\
