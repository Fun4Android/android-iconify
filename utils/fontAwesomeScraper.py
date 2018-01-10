import BeautifulSoup as BS
import requests

mappingUrl = "http://fontawesome.io/cheatsheet/"

def getMapping():
	r = requests.get(mappingUrl)
	if(200 == r.status_code):
		soup = BS.BeautifulSoup(r.text)
		list = soup.findAll('div', {"class": "col-md-4 col-sm-6 col-lg-3 col-print-4"})
		mapping = []
		for tag in list:
			characterCode = tag.find('i').contents[0].replace('&#x', ' ')[1:].encode('ascii')[0:4]
			name = tag.find('i').next.next.strip().replace('-','_').encode('ascii')
			mapping.append({"name": name, "code": characterCode})

		return mapping

def makeJavaEnum(mapping):
	line = "";
	file = "";
	for icon in mapping:
		line = icon['name'] + '(\'\\u' + icon['code'] + '\'),' + "\n"
		file = file + line

	file = file[0: len(file) - 2] + ';'

	f = open("javaEnum.txt","w")
	f.write(file)
	f.close()


if __name__ == '__main__':
	print "generating java enum mapping at javaEnum.txt"
	makeJavaEnum(getMapping())
	print "Done!"