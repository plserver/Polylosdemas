te script permite subir un commit a nuestro repositorio de github.
cd /home/dev/guest
date=`echo date +%c`

git add .
git commit -m "`$date`"
git push -u pol master

if [ $? -eq 0 ];
then
        echo "[CORRECT] Commit de Pol realizado el dia `$date`" >> /var/log/log_commit.txt
        python /scripts-produccion/enviarMailPau.py "[CORRECT]" "Commit realizado Pol"
else
        echo "[ERROR] Commit de Pol no realizado el dia $date" >> /var/log/log_commit.txt
        python /scripts-produccion/enviarMailPau.py "[ERROR]" "Commit erroneo Pol"
fi

