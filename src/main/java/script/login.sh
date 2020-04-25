#!/usr/bin/expect
set username EarWheat
set hostname 123.456.789.123
set timeout -1
set password a123456789

spawn ssh root@hostname
expect "*assword:*"
send "$password\r"
expect "root*"
send "su $username\r"

interact