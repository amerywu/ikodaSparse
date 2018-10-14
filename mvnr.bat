
echo mvn
call mvn clean install

SET /P _success= Build successful?
IF "%_success%"=="y" GOTO :run

GOTO :end

:run

echo copying docs

xcopy C:\Users\jake\__workspace\scalaProjects\ikodaSparse\target\site\scaladocs C:\Users\jake\__workspace\scalaProjects\ikodaSparse\docs\scaladoc /S /E /F /R /Y /I


:end