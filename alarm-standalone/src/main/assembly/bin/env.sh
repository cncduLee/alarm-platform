cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`
CONF_DIR=$DEPLOY_DIR/runtimecfg
CONF_FILE=$CONF_DIR/dubbo.properties

APP="ccmis-standalone"
LOG_BASE="/export/log"
LOG_DIR="$LOG_BASE/$APP"

export JAVA_HOME=/export/local/jdk1.6
export JAVA_BIN=/export/local/jdk1.6/bin
export PATH=$JAVA_BIN:$PATH

export LANG=en_US.UTF-8
export LC_ALL=en_US.UTF-8

get_ip() {
    _nic='eth0'
    _ip=`/sbin/ifconfig $_nic 2>/dev/null | grep 'inet addr:' | cut -d: -f2 | awk '{ print $1}'`
    if [ -z "$_ip" ] ;then
        _nic='em1'
        _ip=`/sbin/ifconfig $_nic 2>/dev/null | grep 'inet addr:' | cut -d: -f2 | awk '{ print $1}'`
    fi
    if [ -z "$_ip" ] ;then
        _nic='br0'
        _ip=`/sbin/ifconfig $_nic 2>/dev/null | grep 'inet addr:' | cut -d: -f2 | awk '{ print $1}'`
    fi
    echo -n "$_ip"
}

check_hostname() {
    ip=`get_ip`
    host_name=`hostname`
    _local="$ip $host_name"
    _etc_hosts="/etc/hosts"
    
    _rv=`grep "$host_name" $_etc_hosts`
    echo "Checking local hostname ...."
    if [ -z "$_rv" ] ;then
        echo "Append [$_local] to $_etc_hosts"
        echo $_local >> $_etc_hosts
    else
        echo "local ip is okay with [$_rv]"
    fi
}
