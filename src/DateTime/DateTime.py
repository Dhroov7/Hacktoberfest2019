from datetime import datetime

now = datetime.now()

print("%s/%s/%s %s:%s:%s" % (now.day, now.month,
                             now.year, now.hour, now.minute, now.second))