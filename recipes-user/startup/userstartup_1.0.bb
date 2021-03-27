SUMMARY = "Initial boot script"
DESCRIPTION = "Custom Start up Script for user specific operations"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit update-rc.d

SRC_URI = " \
	file://setup_script \
	"

RDEPENDS_${PN} += "bash"
INITSCRIPT_NAME = "setup_script"
INITSCRIPT_PARAMS = "start 99 S ."

S = "${WORKDIR}"

do_install () {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/setup_script ${D}${sysconfdir}/init.d
}

FILES_${PN} += "${sysconfdir}/*"