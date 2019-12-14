te script permite subir un commit a nuestro repositorio de github.
cd /home/dev/guest
date=`echo date +%c`

git add .
git commit -m "`$date`"
git push -u pol master

if [ $? -eq 0 ];
then
        echo "[CORRECT] Commit realizado el dia `$date`" >> /var/log/log_commit.txt
        python /scripts-produccion/enviarMail.py "[CORRECT]" "Commit realizado"
else
        echo "[ERROR] Commit realizado el dia $date" >> /var/log/log_commit.txt
        python /scripts-produccion/enviarMail.py "[ERROR]" "Commit erroneo"
fi

