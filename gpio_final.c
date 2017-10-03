/*
 *
 * Toggles led on pin 1 on port N
 *
 * Already set build options (no need to change anything):
 * Stack size set to 1024 byte
 * Heap size disabled - No malloc()
 * No code optimization
 * Strict floating point interrupt behaviour
 * Hardware floating point unit activated
 *
 */

#define TARGET_IS_TM4C129_RA2
#include <stdbool.h> /*driverlib header requires stdbool.h to be included a first header file before any driverlib header*/
#include <stdint.h>
#include <driverlib/gpio.h>
#include <driverlib/pin_map.h>/*supplies GPIO_PIN_x*/
#include <driverlib/sysctl.h>
#include <driverlib/rom.h>
#include <inc/hw_memmap.h>/*supplies GPIO_PORTx_BASE*/

/*Controller is initially clocked with 16MHz*/
/* !! Changing this define does not change clock speed !! */
#define F_CPU 16000000
#define LED_D1 2 //00000010 D1: PN1
#define LED_D2 1 //00000001 D2: PN0
#define LED_D3 16 //00000100 D3: PF4
#define LED_D4 1 //00000001 D4: PF0
#define LED_OFF 0

//Funktionsprototypen
void let_them_shine(uint8_t ui8val);
void led_d1_on(void);
void led_d2_on(void);
void led_d3_on(void);
void led_d4_on(void);
void all_leds_on(void);
void all_leds_off(void);

void main (void) {

    uint32_t ui32Strength;
    uint32_t ui32PinType;

    //SysCtlPeripheralEnable Port n, j, f
    SysCtlPeripheralEnable(SYSCTL_PERIPH_GPION);
    SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOJ);
    SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOF);

    //Input setzen: switch
    GPIOPinTypeGPIOInput(GPIO_PORTJ_BASE, GPIO_PIN_0);

    //ConfigSet & ConfigGet --> LED, switch: STD_WPU (oder pull down)
    GPIOPadConfigGet(GPIO_PORTN_BASE, GPIO_PIN_1, &ui32Strength, &ui32PinType);
    GPIOPadConfigSet(GPIO_PORTN_BASE, GPIO_PIN_1, ui32Strength, GPIO_PIN_TYPE_STD);

    GPIOPadConfigGet(GPIO_PORTN_BASE, GPIO_PIN_0, &ui32Strength, &ui32PinType);
    GPIOPadConfigSet(GPIO_PORTN_BASE, GPIO_PIN_0, ui32Strength, GPIO_PIN_TYPE_STD);

    GPIOPadConfigGet(GPIO_PORTF_BASE, GPIO_PIN_0, &ui32Strength, &ui32PinType);
    GPIOPadConfigSet(GPIO_PORTF_BASE, GPIO_PIN_0, ui32Strength, GPIO_PIN_TYPE_STD);

    //GPIOPadConfigGet für PortN beide Ports und für PortF Port 0 -> Port 4 auslassen weil er bereits konfiguriert ist (Standardmäßig lt. Plan)
    GPIOPadConfigGet(GPIO_PORTF_BASE, 4, &ui32Strength, &ui32PinType);
    GPIOPadConfigSet(GPIO_PORTF_BASE, 4, ui32Strength, GPIO_PIN_TYPE_STD);

    //switch auf pull up
    GPIOPadConfigGet(GPIO_PORTJ_BASE, GPIO_PIN_0, &ui32Strength, &ui32PinType);
    GPIOPadConfigSet(GPIO_PORTJ_BASE, GPIO_PIN_0, ui32Strength, GPIO_PIN_TYPE_STD_WPU);

    //Output setzen
    GPIOPinTypeGPIOOutput(GPIO_PORTN_BASE, GPIO_PIN_1);
    GPIOPinTypeGPIOOutput(GPIO_PORTN_BASE, GPIO_PIN_0);
    GPIOPinTypeGPIOOutput(GPIO_PORTF_BASE, GPIO_PIN_4);
    GPIOPinTypeGPIOOutput(GPIO_PORTF_BASE, GPIO_PIN_0);



    uint8_t ui8val = 1; //00000001

    for(;;) {

        while(GPIOPinRead(GPIO_PORTJ_BASE, GPIO_PIN_0) == 0)
        {
            //ui8val = 00000001
            let_them_shine(ui8val);
            SysCtlDelay(F_CPU/2/3);

            ui8val = ui8val << 1; //00000010 mit 2 Multiplizieren
            let_them_shine(ui8val);
            SysCtlDelay(F_CPU/2/3);

            ui8val = ui8val ^ 1; //00000011
            let_them_shine(ui8val);
            SysCtlDelay(F_CPU/2/3);

            ui8val = ui8val ^ 1; //00000010
            ui8val = ui8val << 1; //00000100
            let_them_shine(ui8val);
            SysCtlDelay(F_CPU/2/3);

            ui8val = ui8val >> 2;
            let_them_shine(ui8val);

            ui8val = 1;
        }
    }


}

void let_them_shine(uint8_t var) {

    switch(var) {

    case 1: led_d1_on();
        break;
    case 2: led_d2_on();
        break;
    case 3: led_d3_on();
        break;
    case 4: led_d4_on();
        break;
    default:
        break;
    }
}

//TODO: funktion, die entsprechend dem parameter eine lampe leuchten lässt --> switch case

void led_d1_on(void) {
    //GPIO_Pin_Write
    GPIOPinWrite (GPIO_PORTN_BASE, GPIO_PIN_1, LED_D1);
    GPIOPinWrite (GPIO_PORTN_BASE, GPIO_PIN_0, LED_OFF);
    GPIOPinWrite (GPIO_PORTF_BASE, GPIO_PIN_4, LED_OFF);
    GPIOPinWrite (GPIO_PORTF_BASE, GPIO_PIN_0, LED_OFF);

}

void led_d2_on(void) {
    //GPIO_Pin_Write
    GPIOPinWrite (GPIO_PORTN_BASE, GPIO_PIN_1, LED_OFF);
    GPIOPinWrite (GPIO_PORTN_BASE, GPIO_PIN_0, LED_D2);
    GPIOPinWrite (GPIO_PORTF_BASE, GPIO_PIN_4, LED_OFF);
    GPIOPinWrite (GPIO_PORTF_BASE, GPIO_PIN_0, LED_OFF);

}

void led_d3_on(void) {

    GPIOPinWrite (GPIO_PORTN_BASE, GPIO_PIN_1, LED_OFF);
    GPIOPinWrite (GPIO_PORTN_BASE, GPIO_PIN_0, LED_OFF);
    GPIOPinWrite (GPIO_PORTF_BASE, GPIO_PIN_4, LED_D3);
    GPIOPinWrite (GPIO_PORTF_BASE, GPIO_PIN_0, LED_OFF);

}

void led_d4_on(void) {

    GPIOPinWrite (GPIO_PORTN_BASE, GPIO_PIN_1, LED_OFF);
    GPIOPinWrite (GPIO_PORTN_BASE, GPIO_PIN_0, LED_OFF);
    GPIOPinWrite (GPIO_PORTF_BASE, GPIO_PIN_4, LED_OFF);
    GPIOPinWrite (GPIO_PORTF_BASE, GPIO_PIN_0, LED_D4);
}

void all_leds_on(void) {

    GPIOPinWrite (GPIO_PORTN_BASE, GPIO_PIN_1, LED_D1);
    GPIOPinWrite (GPIO_PORTN_BASE, GPIO_PIN_0, LED_D2);
    GPIOPinWrite (GPIO_PORTF_BASE, GPIO_PIN_4, LED_D3);
    GPIOPinWrite (GPIO_PORTF_BASE, GPIO_PIN_0, LED_D4);
}

void all_leds_off(void) {

    GPIOPinWrite (GPIO_PORTN_BASE, GPIO_PIN_1, LED_OFF);
    GPIOPinWrite (GPIO_PORTN_BASE, GPIO_PIN_0, LED_OFF);
    GPIOPinWrite (GPIO_PORTF_BASE, GPIO_PIN_4, LED_OFF);
    GPIOPinWrite (GPIO_PORTF_BASE, GPIO_PIN_0, LED_OFF);
}
