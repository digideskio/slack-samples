# Google App Engine Standard Environment Hello World Sample

0. Make a team

See "before you begin" at the incoming web hooks tutorial.

1. Make a Slack App

https://api.slack.com/slack-apps
https://api.slack.com/apps/new

Do I need to do this OAuth2 stuff?

- Set the callback in the registration form to
  https://YOUR-PROJECT.appspot.com/oauth2callback, replace YOUR-PROJECT with
  your Google Cloud Project ID.
- Write the Client ID and Client Secret it gives you to config.go.
- Attach a new slash command to the app. Point it at
  https://YOUR-PROJECT.appspot.com/quotes/random, replace YOUR-PROJECT with
  your Google Cloud Project ID. Give it a name like /happycloudapp.
- Write the token it gives you to config.go.

I do need the "token". Where is that? It appears after I set up the OAuth2
callback.

2. Add a bot user

3. Event Subscriptions -> Enable events. Do I need this if I have a bot user?



This sample demonstrates how to deploy an application on Google App Engine.

See the [Google App Engine standard environment documentation][ae-docs] for more
detailed instructions.

[ae-docs]: https://cloud.google.com/appengine/docs/java/

## Setup

Use either:

* `gcloud init`
* `gcloud beta auth application-default login`

## Maven
### Running locally

    $ mvn appengine:run

### Deploying

    $ mvn appengine:deploy

## Gradle
### Running locally

    $ gradle appengineRun

If you do not have gradle installed, you can run using `./gradlew appengineRun`.

### Deploying

    $ gradle appengineDeploy

If you do not have gradle installed, you can deploy using `./gradlew appengineDeploy`.

<!-- 
## Intelij Idea
Limitations - Appengine Standard support in the Intellij plugin is only available for the Ultimate Edition of Idea.

### Install and Set Up Cloud Tools for IntelliJ

To use Cloud Tools for IntelliJ, you must first install IntelliJ IDEA Ultimate edition.

Next, install the plugins from the IntelliJ IDEA Plugin Repository.

To install the plugins:

1. From inside IDEA, open File > Settings (on Mac OS X, open IntelliJ IDEA > Preferences).
1. In the left-hand pane, select Plugins.
1. Click Browse repositories.
1. In the dialog that opens, select Google Cloud Tools.
1. Click Install.
1. Click Close.
1. Click OK in the Settings dialog.
1. Click Restart (or you can click Postpone, but the plugins will not be available until you do restart IDEA.)

### Running locally

### Deploying
 -->
