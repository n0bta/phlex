[![](https://jitpack.io/v/n0bta/phlex.svg)](https://jitpack.io/#n0bta/phlex)

# phlex

A Java-based scraper designed to view Jurisprudence data from Lawphil. 

## Getting Started

Prerequisite for Android users: [jsoup Android support](https://github.com/jhy/jsoup?tab=readme-ov-file#android-support)

1. Add to your root build.gradle
```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

2. Add the dependency
```
dependencies {
    implementation 'com.github.n0bta:phlex:-efdc3daded-1'
}
```

3. Use Phlex class like so:
``` Java
List<PhlexCase> a = Phlex.getCases(2002, Phlex.MONTHS[7]);
for (PhlexCase b : a) {
    System.out.println(b.toString());
}
```
See full example code: [Example.java](https://github.com/n0bta/phlex/blob/master/src/main/java/org/example/Example.java)

## License

This project is licensed under The Unlicense license.

## Contributing

Contributions are welcome to this project. Please submit a pull request to the repository.

## Note
* This scraper is intended for educational purposes only.
* Using this scraper in violation of Lawphil's terms of service is strictly prohibited.
* Always respect the website's robots.txt and rate limits.
* The author is not responsible for any damages or any other consequences arising from the use of this code.
