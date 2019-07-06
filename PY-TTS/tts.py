# On Linux, Insatll Espeak module
# e.g. Ubuntu - sudo apt install espeak
import pyttsx3
tts = pyttsx3.init('espeak')
voices = tts.getProperty('voices')
'''
for voice in voices:
    tts.setProperty('voice', voice.id)
    print(voice.id)
    tts.say('Hello Shakeel, how are you today. Hope you are doing good.')
    tts.runAndWait()
'''