import boto3
import json

rekognition = boto3. client('rekognition')
collection_id = 'MyCollection'
result = rekognition.delete_collection(Collectionld=collection_id)
print(json. dumps(result, indent=4))
