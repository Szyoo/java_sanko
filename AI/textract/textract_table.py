import boto3
import json
import sys
from PIL import Image

if len(sys.argv) != 2:
    print('python', sys.argv[0], 'image')
    exit()

region = 'us-east-1'
textract = boto3.client('textract', region)
with open(sys.argv[1], 'rb') as file:
    result = textract.detect_document_text(
        Document={'Bytes': file.read()})
    print(json.dumps(result, indent=4))

image_in = Image.open(sys.argv[1])
w, h = image_in.size
image_out = Image.new('RGB', (w, h), (200, 200, 200))
# ここ以降書く

text = {}
for block in result['Blocks']:
    if 'Text' in block:
        text[block['Id']] = block['Text']

cell = {}
for block in result['Blocks']:
    if block['BlockType'] == 'CELL':
        row = int(block['Rowlndex'])-1
        column = int(block['ColumnIndex'])-1
        cell[(row, column)] = ''
        if 'Relationships' in block:
            for relationship in block['Relationships']:
                if relationship['Type'] == 'CHILD':
                    for id in relationship['Ids']:
                        if id in text:
                            cell[(row, column)] += text[id] + ''

for row in range(8):
    for column in range(4):
        if (row, column) in cell:
            print('{:20}'.format(cell[(row, column)]), end="")
    print()
