cd /vagrant
nohup grunt > target/grunt.log &
service elasticsearch start
service openidm start
