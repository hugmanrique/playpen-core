USERNAME=hugmanrique
IMAGE=playpen
VERSION=1.1.2

mvn clean package

docker tag $USERNAME/$IMAGE:latest $USERNAME/$IMAGE:$VERSION

docker push $USERNAME/$IMAGE:latest
docker push $USERNAME/$IMAGE:$VERSION