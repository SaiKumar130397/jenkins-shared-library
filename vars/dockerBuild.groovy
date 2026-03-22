def call(String imageName, String tag, String target = '') {
    if (target) {
        sh "docker build --target ${target} -t ${imageName}:${tag} ."
    } else {
        sh "docker build -t ${imageName}:${tag} ."
    }
}