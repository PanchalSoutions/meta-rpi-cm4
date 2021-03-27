# Base this image on core-image-minimal
include recipes-core/images/core-image-minimal.bb

# Include modules in rootfs
IMAGE_INSTALL += " \
	kernel-modules \
	"

PREFERRED_PROVIDER_virtual/java-initial-native = "cacao-initial-native"
PREFERRED_PROVIDER_virtual/java-native = "cacao-native"
PREFERRED_PROVIDER_virtual/javac-native = "ecj-bootstrap-native"

DISTRO_FEATURES_remove = " bluez5 bluetooth wifi"

IMAGE_INSTALL_append = " openjdk-8 						\
						packagegroup-core-tools-debug 	\
						packagegroup-core-full-cmdline 	\
						packagegroup-rpi-test			\
						i2c-tools						\
						spidev-test						\
						usbutils						\
						userstartup						\
						mono 							\
						mono-helloworld					\
						"

IMAGE_FEATURES += "ssh-server-dropbear"