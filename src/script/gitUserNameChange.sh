#!/usr/bin/expect
set timeout 30
set personalUserName EarWheat
set personalUserEmail 2636965138@qq.com
lindex $argv 0

spawn git config --global user.name $personalUserName  $argv
interact
spawn git config --global user.email $personalUserEmail
interact
spawn git add .
interact
spawn git commit -m "commit_message" .
interact
spawn git push origin master.
interact
