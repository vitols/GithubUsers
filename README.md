# GithubUsers Android App

The app shows users (cards with their info: photo with the count of repositories, name, location, company) in order they signed up on GitHub.
Tapping on the user you will see the list of their repositories (name and creation date). 
Based on MVP pattern. Works with Github API.

## Getting Started

You need to register the app on Github, then take CLIENT_ID and CLIENT_SECRET and put them to GithubAPI.java file in order to be able to do authorized requests. Otherwise you can just remove Interceptor part from there.

### Screenshots

<div style="display:flex;">
<img style="margin-left:10px;" src="screenshots/1.png" width="30%" >
<img style="margin-left:10px;" src="screenshots/2.png" width="30%" >
</div>

#### Built With

* [Java 8](https://java.com/en/download/)
* [RxJava](https://github.com/ReactiveX/RxJava) - A library for composing asynchronous and event-based programs
* [Glide](https://github.com/bumptech/glide) - Image loading framework
* [ThreeTenABP](https://github.com/JakeWharton/ThreeTenABP) - Working with time
* [CircleImageView](https://github.com/hdodenhof/CircleImageView) - Let create circle image views
* [Retrofit](http://square.github.io/retrofit/) - Http client
* [Retrolambda](https://github.com/evant/gradle-retrolambda) - Plugin for lambdas using
