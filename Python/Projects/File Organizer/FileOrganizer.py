import os
import shutil

path = input('Desired Path to Organize: ')
files = os.listdir(path)

file_extensions = {
'.pdf': 'documents',
'.png': 'pictures',
'.jpg': 'pictures',
'.jpeg': 'pictures',
'.gif': 'pictures',
'.pptx': 'documents/Presentations',
'.odp': 'documents/Presentations',
'.doc': 'documents',
'.docx': 'documents',
'.txt': 'documents',
'.csv': 'documents/Datasheets',
'.xlsx': 'documents/Datasheets',
'.zip': 'documents/Executables',
'.rar': 'documents/Executables',
'.exe': 'documents/Executables',
'.mp3': 'music',
'.mp4': 'movies',
'.avi': 'movies',
'.flv': 'movies',
'.mov': 'movies',
'.wmv': 'movies'}


for file in files:
    filename, extension = os.path.splitext(file)
    extension.lower()
    if extension in file_extensions:
        shutil.copy(path, 'users/dchavre/' + file_extensions.get(extension))
    else:
        continue
    
    
